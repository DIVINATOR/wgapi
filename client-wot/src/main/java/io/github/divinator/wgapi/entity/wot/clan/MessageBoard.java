package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

/**
 * Класс описывает сущность "Сообщения доски объявлений клана" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class MessageBoard {

    @SerializedName("author_id")
    private int authorId;

    @SerializedName("created_at")
    private int createdAt;

    @SerializedName("editor_id")
    private int editorId;

    @SerializedName("is_read")
    private boolean isRead;

    @SerializedName("message")
    private String message;

    @SerializedName("updated_at")
    private int updatedAt;

    /**
     * Метод возвращает идентификатор автора объявления.
     * @return Идентификатор автора объявления.
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * Метод возвращает дата создания объявления.
     * @return Дата создания объявления.
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Метод возвращает идентификатор игрока, изменившего объявление.
     * @return Идентификатор игрока, изменившего объявление.
     */
    public int getEditorId() {
        return editorId;
    }

    /**
     * Метод показывает, прочитано ли объявление.
     * @return показывает, прочитано ли объявление.
     */
    public boolean isRead() {
        return isRead;
    }

    /**
     * Метод возвращает текст сообщения
     * @return Текст сообщения.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Метод возвращает дату обновления сообщения.
     * @return Дата обновления сообщения.
     */
    public int getUpdatedAt() {
        return updatedAt;
    }
}
