package com.anubis.core.util;

import com.anubis.core.exception.AnubisPythonExecutionException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class PythonExecUtil {

    private static final Logger LOG = LoggerFactory.getLogger(PythonExecUtil.class);

    public static String[] executePythonScript(String scriptPath) throws AnubisPythonExecutionException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler psh = new PumpStreamHandler(outputStream);
        Integer exitValue = -1;
        //
        File file = new File(scriptPath);

        try {
            String line = "python " + file.getCanonicalPath();
            //
            CommandLine commandLine = CommandLine.parse(line);
            DefaultExecutor executor = new DefaultExecutor();
            executor.setStreamHandler(psh);
            //
            exitValue = executor.execute(commandLine);
        } catch (ExecuteException Exe) {
            LOG.error("An error occured executing Python file: {}", scriptPath);
            LOG.error("ExecutionException:", Exe.getMessage());
            throw new AnubisPythonExecutionException("An error occured executing Python file: " + scriptPath, exitValue);
        } catch (Exception Rex) {
            LOG.error("An error occured executing Python file: {}", scriptPath);
            LOG.error("Exception:", Rex.getMessage());
            throw new AnubisPythonExecutionException("An error occured executing Python file: " + scriptPath, exitValue);
        }
        return outputStream.toString().split("\\R");
    }
}
