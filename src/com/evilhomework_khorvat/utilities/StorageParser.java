package com.evilhomework_khorvat.utilities;

import com.evilhomework_khorvat.models.StorageEntry;
import com.evilhomework_khorvat.interfaces.Parser;

public class StorageParser implements Parser<StorageEntry> {
    @Override
    public StorageEntry parse(String line) {
        String[] parts = line.split(";");
        return new StorageEntry(parts[0], Integer.parseInt(parts[1]));
    }
}
