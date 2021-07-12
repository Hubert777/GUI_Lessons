package com.company.Interfaces;

import com.company.Exceptions.TooManyThingsException;
import com.company.Item;

public interface IStorage{
    void putItem(Item item) throws TooManyThingsException;
    void removeItem(Item item);
}
