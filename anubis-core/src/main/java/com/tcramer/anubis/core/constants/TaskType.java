package com.tcramer.anubis.core.constants;

import java.util.HashMap;
import java.util.Map;

public enum TaskType {
    DAILY(0, Name.DAILY, Discriminator.DAILY),
    ON_X_DAYS(1, Name.ON_X_DAYS, Discriminator.ON_X_DAYS),
    EVERY_OTHER_DAY(2, Name.EVERY_OTHER_DAY, Discriminator.EVERY_OTHER_DAY),
    EVERY_N_DAYS(3, Name.EVERY_N_DAYS, Discriminator.EVERY_N_DAYS),
    WEEKLY(4, Name.WEEKLY, Discriminator.WEEKLY),
    FIRST_WEEK(5, Name.FIRST_WEEK, Discriminator.FIRST_WEEK),
    LAST_WEEK(6, Name.LAST_WEEK, Discriminator.LAST_WEEK),
    WEEK_OF(7, Name.WEEK_OF, Discriminator.WEEK_OF),
    BEFORE(8, Name.BEFORE, Discriminator.BEFORE),
    AFTER(9, Name.AFTER, Discriminator.AFTER);

    static final private Map<String, TaskType> TASK_TYPE_NAME_MAP = new HashMap<String, TaskType>();
    static final private Map<Integer, TaskType> TASK_TYPE_ID_MAP = new HashMap<Integer, TaskType>();
    static final private Map<String, TaskType> TASK_TYPE_DISCRIM_MAP = new HashMap<String, TaskType>();

    static {
        for (TaskType taskType : TaskType.values()) {
            TASK_TYPE_NAME_MAP.put(taskType.name(), taskType);
            TASK_TYPE_ID_MAP.put(taskType.getId(), taskType);
            TASK_TYPE_DISCRIM_MAP.put(taskType.getDiscriminator(), taskType);
        }
    }

    private final int id;
    private final String name;
    private final String discriminator;

    TaskType(int id, String name, String discriminator) {
        this.id = id;
        this.name = name;
        this.discriminator = discriminator;
    }

    public static TaskType getById(int id) {
        return TASK_TYPE_ID_MAP.get(id);
    }

    public static TaskType getByName(String name) {
        return TASK_TYPE_NAME_MAP.get(name);
    }

    public static TaskType getByDiscrim(String discriminator) {
        return TASK_TYPE_DISCRIM_MAP.get(discriminator);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public static class Discriminator {
        public static final String BASE             = "A0";
        public static final String DAILY            = "T0";
        public static final String ON_X_DAYS        = "T1";
        public static final String EVERY_OTHER_DAY  = "T2";
        public static final String EVERY_N_DAYS     = "T3";
        public static final String WEEKLY           = "T4";
        public static final String FIRST_WEEK       = "T5";
        public static final String LAST_WEEK        = "T6";
        public static final String WEEK_OF          = "T7";
        public static final String BEFORE           = "T8";
        public static final String AFTER            = "T9";
    }

    public static class Name {
        public static final String DAILY            = "DAILY";
        public static final String ON_X_DAYS        = "ON_X_DAYS";
        public static final String EVERY_OTHER_DAY  = "EVERY_OTHER_DAY";
        public static final String EVERY_N_DAYS     = "EVERY_N_DAYS";
        public static final String WEEKLY           = "WEEKLY";
        public static final String FIRST_WEEK       = "FIRST_WEEK";
        public static final String LAST_WEEK        = "LAST_WEEK";
        public static final String WEEK_OF          = "WEEK_OF";
        public static final String BEFORE           = "BEFORE";
        public static final String AFTER            = "AFTER";
    }
}
