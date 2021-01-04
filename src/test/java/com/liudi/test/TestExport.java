package com.liudi.test;

import com.liudi.export.ExportExcel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2020/12/24 上午11:40
 */
public class TestExport {

    @Test
    public void testExport() throws IOException {
        ExportExcel exportExcel = new ExportExcel();
        exportExcel.testExportExcel();
    }
}
