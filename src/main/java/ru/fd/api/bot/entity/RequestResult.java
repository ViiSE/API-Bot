package ru.fd.api.bot.entity;

public interface RequestResult<T> {
    Object findObjectByKey(Object key);
    T data();
}
