package com.lujiaxin.sop.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    public static List page(int page, int size, List list) {
        int fromIndex = (page - 1) * size;
        int toIndex = page * size;
        if (fromIndex > list.size())
            return new ArrayList<>();
        else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        } else {
            return list.subList(fromIndex, toIndex);
        }
    }

}
