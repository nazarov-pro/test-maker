/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.other;

import java.util.UUID;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public class GenerateUUID {

    private GenerateUUID() {

    }

    public static String getGeneratedUUID() {
        return UUID.randomUUID().toString();
    }
}
