package io.github.divinator.wgapi.entity.wot.clanratings;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanRatingsMethod;

import java.util.List;

/**
 * Класс описывает сущность "Информация о типах и категориях рейтингов" для метод-блока {@link ClanRatingsMethod}
 *
 * @author Sergey Divin
 */
public final class TypesRatings {

    @SerializedName("rank_fields")
    private List<String> rankFields;

    @SerializedName("type")
    private String type;

    /**
     * Метод возвращает категории рейтинга.
     *
     * @return Категории рейтинга.
     */
    public List<String> getRankFields() {
        return rankFields;
    }

    /**
     * Метод возвращает период формирования рейтинга.
     *
     * @return Период формирования рейтинга.
     */
    public String getType() {
        return type;
    }
}
