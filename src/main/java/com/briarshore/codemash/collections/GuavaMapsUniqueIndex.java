package com.briarshore.codemash.collections;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

import com.google.common.base.Function;

public class GuavaMapsUniqueIndex {
    static final String SCHEDULED_TIME_ADJUSTMENT_SUFFIX = "wood";
    static final int SCHEDULED_TIME_ADJUSTMENT_SUFFIX_LENGTH = SCHEDULED_TIME_ADJUSTMENT_SUFFIX.length();
    static final long MINUTES_SCHEDULED_TIME_ADJUSTMENT = 30L;
    static final BiFunction<String, LocalDateTime, LocalDateTime> scheduledTimeAdjustment = new BiFunction<String, LocalDateTime, LocalDateTime>() {
        @Override
        public LocalDateTime apply(final String key, final LocalDateTime value) {
            return SCHEDULED_TIME_ADJUSTMENT_SUFFIX.regionMatches(true, 0, key, key.length() - SCHEDULED_TIME_ADJUSTMENT_SUFFIX_LENGTH, SCHEDULED_TIME_ADJUSTMENT_SUFFIX_LENGTH) ? value.plusMinutes(
                    MINUTES_SCHEDULED_TIME_ADJUSTMENT) : value;
        }
    };
    static final Function<ScheduledSession, String> extractLocation = new Function<ScheduledSession, String>() {
        @Override
        public String apply(final ScheduledSession s) {
            return null != s ? s.getWhere() : "TBD";
        }
    };
    static final Function<ScheduledSession, LocalDateTime> extractDateTime = new Function<ScheduledSession, LocalDateTime>() {
        @Override
        public LocalDateTime apply(final ScheduledSession s) {
            return null != s ? s.getWhen() : null;
        }
    };
    static Function<ScheduledSession, String> extractSpeaker = new Function<ScheduledSession, String>() {
        @Override
        public String apply(final ScheduledSession s) {
            return null != s ? s.getWho() : "TBD";
        }
    };
}
