package com.dao.type;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-10-04
 * Copyright  "Commercegate LTD"
 */
public enum AppointmentState {
    Unknown {
        public final Integer getValue() {
            return 0;
        }

        public final String getName() {
            return "Unknown";
        }
    },
    New {
        public final Integer getValue() {
            return 1;
        }

        public final String getName() {
            return "New";
        }
    },
    Record {
        public final Integer getValue() {
            return 2;
        }

        public final String getName() {
            return "Record";
        }
    },
    CloseReason {
        public final Integer getValue() {
            return 3;
        }

        public final String getName() {
            return "CloseReason";
        }
    },
    Success {
        public final Integer getValue() {
            return 4;
        }

        public final String getName() {
            return "Success";
        }
    }
}
