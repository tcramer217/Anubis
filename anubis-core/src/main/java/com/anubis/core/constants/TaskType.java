package com.anubis.core.constants;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TaskType {
    BASE(1337, Name.BASE, Discriminator.BASE, "base"),
    DAILY(0, Name.DAILY, Discriminator.DAILY, "daily"),
    ON_X_DAYS(1, Name.ON_X_DAYS, Discriminator.ON_X_DAYS, "on-days"),
    EVERY_OTHER_DAY(2, Name.EVERY_OTHER_DAY, Discriminator.EVERY_OTHER_DAY, "every-other"),
    EVERY_N_DAYS(3, Name.EVERY_N_DAYS, Discriminator.EVERY_N_DAYS, "every-n"),
    WEEKLY(4, Name.WEEKLY, Discriminator.WEEKLY, "weekly"),
    FIRST_WEEK(5, Name.FIRST_WEEK, Discriminator.FIRST_WEEK, "first-week"),
    LAST_WEEK(6, Name.LAST_WEEK, Discriminator.LAST_WEEK, "last-week"),
    WEEK_OF(7, Name.WEEK_OF, Discriminator.WEEK_OF, "week-of"),
    BEFORE(8, Name.BEFORE, Discriminator.BEFORE, "before"),
    AFTER(9, Name.AFTER, Discriminator.AFTER, "after");

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
    private final String endpoint;

    TaskType(int id, String name, String discriminator, String endpoint) {
        this.id = id;
        this.name = name;
        this.discriminator = discriminator;
        this.endpoint = endpoint;
    }

    public static TaskType getById(int id) {
        return TASK_TYPE_ID_MAP.get(id);
    }

    public static TaskType getByName(String name) {
        return TASK_TYPE_NAME_MAP.get(name);
    }

    public static TaskType getByDiscriminator(String discriminator) {
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

    public String getEndpoint() {
        return endpoint;
    }

    public static class Discriminator {
        public static final List<String> DISCRIMINATORS = new ArrayList<>(10);

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

        static {
            DISCRIMINATORS.add(BASE);
            DISCRIMINATORS.add(DAILY);
            DISCRIMINATORS.add(ON_X_DAYS);
            DISCRIMINATORS.add(EVERY_OTHER_DAY);
            DISCRIMINATORS.add(EVERY_N_DAYS);
            DISCRIMINATORS.add(WEEKLY);
            DISCRIMINATORS.add(FIRST_WEEK);
            DISCRIMINATORS.add(LAST_WEEK);
            DISCRIMINATORS.add(WEEK_OF);
            DISCRIMINATORS.add(BEFORE);
            DISCRIMINATORS.add(AFTER);
        }

        public static List<String> getDiscriminators() {
            return DISCRIMINATORS;
        }
    }

    public static class Name {
        public static final List<String> NAMES = new ArrayList<>(10);

        public static final String BASE             = "BASE";
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

        static {
            NAMES.add(BASE);
            NAMES.add(DAILY);
            NAMES.add(ON_X_DAYS);
            NAMES.add(EVERY_OTHER_DAY);
            NAMES.add(EVERY_N_DAYS);
            NAMES.add(WEEKLY);
            NAMES.add(FIRST_WEEK);
            NAMES.add(LAST_WEEK);
            NAMES.add(WEEK_OF);
            NAMES.add(BEFORE);
            NAMES.add(AFTER);
        }

        public static List<String> getNames() {
            return NAMES;
        }
    }
}
