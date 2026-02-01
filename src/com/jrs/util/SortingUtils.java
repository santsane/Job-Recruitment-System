package com.jrs.util;

import com.jrs.model.User;
import java.util.List;
import java.util.Comparator;

public class SortingUtils {

    // Sort by Name using Lambda
    public static void sortUsersByName(List<User> users) {
        users.sort((u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()));
    }

    // Sort by ID using Lambda
    public static void sortUsersById(List<User> users) {
        users.sort(Comparator.comparingInt(User::getId));
    }
}