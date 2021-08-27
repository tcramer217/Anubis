package com.anubis.core.util;

import com.anubis.core.exception.AnubisPythonExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.File;

import static com.anubis.core.AnubisTestConstants.PYTHON_TEST_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

@DisplayName("Verify the functionality of the PythonExecUtil.")
public class PythonExecUtilTest {

    @Test
    public void executePythonScript() throws AnubisPythonExecutionException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(PYTHON_TEST_FILE).getFile());
        String absolutePath = file.getAbsolutePath();
        String[] result = PythonExecUtil.executePythonScript(absolutePath);

        try(MockedStatic mocked = mockStatic(PythonExecUtil.class)) {
            String[] expected = new String[]{"1"};
            mocked.when(() -> PythonExecUtil.executePythonScript(absolutePath)).thenReturn(expected);
            assertEquals(expected, PythonExecUtil.executePythonScript(absolutePath));
        }
        assertEquals("Test Completed.", result[0]);
    }

}
