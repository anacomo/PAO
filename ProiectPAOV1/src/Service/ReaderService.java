package Service;

import IO.Output;
import Library.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderService {
    private List<Reader> readerList;
    private static ReaderService instance = null;

    private ReaderService() {
        readerList = new ArrayList<>();
    }

    public static ReaderService getInstance() {
        if(instance == null) {
            instance = new ReaderService();
        }
        return instance;
    }

    public void addReader(Reader reader, boolean csv) {
        boolean exists = false;
        for(Reader r : readerList)
            if (r.equals(reader)) {
                exists = true;
                break;
            }
        if(!exists) {
            readerList.add(new Reader(reader));
            if (!csv) {
                Output.writeReaderOnCsv(reader);
                Output.userAudit("Add Reader");
            }
            sortReaders();
        }
    }

    private void sortReaders() {
        Collections.sort(readerList);
    }

    public void showReaders() {
        for(Reader r : readerList)
            System.out.println(r.toString());
    }
}
