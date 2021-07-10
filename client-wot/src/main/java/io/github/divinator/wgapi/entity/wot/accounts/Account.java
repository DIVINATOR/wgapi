package io.github.divinator.wgapi.entity.wot.accounts;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.AccountsMethod;

/**
 * Класс описывает сущность "Акаунт игрока" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class Account {

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("account_id")
    private int accountId;

    /**
     * Метод возвращает имя игрока
     * @return Имя игрока
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Метод возвращает идентификатор игрока
     * @return Идентификатор игрока
     */
    public int getAccountId() {
        return accountId;
    }
}
