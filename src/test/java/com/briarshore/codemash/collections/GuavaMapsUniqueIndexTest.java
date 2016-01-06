package com.briarshore.codemash.collections;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GuavaMapsUniqueIndexTest {
    private static final LocalDateTime scheduledSessionStartTime = LocalDateTime.of(2016, Month.JANUARY, 7, 8, 0, 0);

    private GuavaMapsUniqueIndex subject;

    private final List<ScheduledSession> scheduledSessions = Lists.newArrayList(
            new ScheduledSession("The How and Why of Software Patents", "Winkler", scheduledSessionStartTime, "Aloeswood/Leopardwood"),
            new ScheduledSession("Good writing is good design", "Holmer", scheduledSessionStartTime, "Cypress"),
            new ScheduledSession("Object-Oriented Programming Basics with Smalltalk", "Staton Jr.", scheduledSessionStartTime, "Guava/Tamarind"),
            new ScheduledSession("Ten Tricks For Collections You Aren't Using But Should Be!", "Swing", scheduledSessionStartTime, "Indigo Bay"),
            new ScheduledSession("Software In Motion: Continuous Delivery for Mobile", "Truxall", scheduledSessionStartTime, "Mangrove"),
            new ScheduledSession("CQRS 2.0", "Hoerster", scheduledSessionStartTime, "Nile"),
            new ScheduledSession("Docker in production? Done that, what’s next?", "Simon", scheduledSessionStartTime, "Orange"),
            new ScheduledSession("RIOT - A React-like user interface micro-library", "Ward", scheduledSessionStartTime, "Portia/Wisteria"),
            new ScheduledSession("Shoestring Agility in a Velcro Organization", "Schlair", scheduledSessionStartTime, "Rosewood"),
            new ScheduledSession("Is your API leaking? Breaking APIs to increase security.", "Kuemerle", scheduledSessionStartTime, "Sagewood/Zebrawood"),
            new ScheduledSession("Six Degrees of Dev'n - How Graph Databases Can Save Your Bacon", "Miller", scheduledSessionStartTime, "Salon A"),
            new ScheduledSession("Quantifying your Fitness", "Hunter", scheduledSessionStartTime, "Salon D"),
            new ScheduledSession("The Hitchhiker's Guide to Azure Mobile Apps", "Giard", scheduledSessionStartTime, "Salon E"),
            new ScheduledSession("Show It!: Better Testing through Visual Communication", "Lancaster", scheduledSessionStartTime, "Salon H"),
            new ScheduledSession("Node.js Crash Course", "Neal", scheduledSessionStartTime, "Zambezi"));

    @Before
    public void setUp() throws Exception {
        subject = new GuavaMapsUniqueIndex();
    }

    @Test
    public void testTrickNumber03() throws Exception {

        final Map<String, ScheduledSession> sessionsBySpeaker = Maps.uniqueIndex(scheduledSessions, GuavaMapsUniqueIndex.extractSpeaker);
        Assert.assertEquals("expected match", scheduledSessions.size(), sessionsBySpeaker.size());

        final String expectedSpeaker = "Swing";
        final ScheduledSession javaCollections = sessionsBySpeaker.get(expectedSpeaker);
        Assert.assertEquals("expected match", expectedSpeaker, javaCollections.getWho());

        final Map<String, ScheduledSession> sessionsByLocation = Maps.uniqueIndex(scheduledSessions, GuavaMapsUniqueIndex.extractLocation);
        Assert.assertEquals("expected match", scheduledSessions.size(), sessionsByLocation.size());

        final String expectedLocation = "Indigo Bay";
        final ScheduledSession indigoBaySession = sessionsByLocation.get(expectedLocation);
        Assert.assertNotNull("expected non-null", indigoBaySession);
        Assert.assertEquals("expected match", expectedLocation, indigoBaySession.getWhere());

        Assert.assertEquals("expected match", indigoBaySession, javaCollections);

        final Map<String, ScheduledSession> adjustedScheduledSessionsByLocation = Maps.transformEntries(sessionsByLocation, new Maps.EntryTransformer<String, ScheduledSession, ScheduledSession>() {
            @Override
            public ScheduledSession transformEntry(final String key, final ScheduledSession scheduledSession) {
                scheduledSession.setWhen(GuavaMapsUniqueIndex.scheduledTimeAdjustment.apply(key, scheduledSession.getWhen()));
                return scheduledSession;
            }
        });

//        Assert.assertNotNull("expected non-null", adjustedScheduledSessionsByLocation);
//        Assert.assertFalse("expected false", adjustedScheduledSessionsByLocation.isEmpty());
//        new LinkedHashMap<>(adjustedScheduledSessionsByLocation);

//        sessionsByLocation.replaceAll(new BiFunction<String, ScheduledSession, ScheduledSession>() {
//            @Override
//            public ScheduledSession apply(final String s, final ScheduledSession scheduledSession) {
//                scheduledSession.setWhen(Guava.scheduledTimeAdjustment.apply(s, scheduledSession.getWhen()));
//                return scheduledSession;
//            }
//        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapUniqueIndexFromNonUniqueValue() throws Exception {
        final Map<LocalDateTime, ScheduledSession> sessionsByDateTime = Maps.uniqueIndex(scheduledSessions, GuavaMapsUniqueIndex.extractDateTime);
        Assert.fail("expected an exception to be thrown");
    }

    @Test
    public void testScheduledTimeAdjustmentAdjusted() throws Exception {
        final LocalDateTime expected = LocalDateTime.of(2016, Month.JANUARY, 7, 8, 30, 0);
        final LocalDateTime actual = GuavaMapsUniqueIndex.scheduledTimeAdjustment.apply("wood", scheduledSessionStartTime);
        Assert.assertEquals("expected match", expected, actual);
    }

    @Test
    public void testScheduledTimeAdjustmentAdjustedBetterSuffixCheckSandalwood() throws Exception {
        final LocalDateTime expected = LocalDateTime.of(2016, Month.JANUARY, 7, 8, 30, 0);
        final LocalDateTime actual = GuavaMapsUniqueIndex.scheduledTimeAdjustment.apply("Sandalwood", scheduledSessionStartTime);
        Assert.assertEquals("expected match", expected, actual);
    }

    @Test
    public void testScheduledTimeAdjustmentNone() throws Exception {
        final LocalDateTime expected = scheduledSessionStartTime;
        final LocalDateTime actual = GuavaMapsUniqueIndex.scheduledTimeAdjustment.apply("hickory", scheduledSessionStartTime);
        Assert.assertEquals("expected match", expected, actual);
        Assert.assertSame("expected same", expected, actual);
    }

    @Test
    public void testScheduledTimeAdjustmentNoneButClose() throws Exception {
        final LocalDateTime expected = scheduledSessionStartTime;
        final LocalDateTime actual = GuavaMapsUniqueIndex.scheduledTimeAdjustment.apply("hickorywoods", scheduledSessionStartTime);
        Assert.assertEquals("expected match", expected, actual);
        Assert.assertSame("expected same", expected, actual);
    }
}
