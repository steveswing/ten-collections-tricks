package com.briarshore.codemash.collections;

import java.time.LocalDateTime;

public class ScheduledSession {
    private String what;
    private String who;
    private LocalDateTime when;
    private String where;

    public ScheduledSession(final String what, final String who, final LocalDateTime when, final String where) {
        this.what = what;
        this.who = who;
        this.when = when;
        this.where = where;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(final String what) {
        this.what = what;
    }

    public String getWho() {
        return who;
    }

    public void setWho(final String who) {
        this.who = who;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(final LocalDateTime when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(final String where) {
        this.where = where;
    }
}
