package io.github.divinator.wgapi.entity.wot.clanratings;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanRatingsMethod;

import java.util.List;

/**
 * Класс описывает сущность "Даты, за которые есть рейтинговые данные" для метод-блока {@link ClanRatingsMethod}
 *
 * @author Sergey Divin
 */
public final class DatesRatings {

    @SerializedName("dates")
    private List<Integer> dates;

    /**
     * Метод возвращает список дат, за которые есть рейтинговые данные.
     *
     * @return Список дат, за которые есть рейтинговые данные.
     */
    public List<Integer> getDates() {
        return dates;
    }
}
