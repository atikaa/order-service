package data.json.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonDataSupport {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
    }

    public static <T> T getJsonObject(String fileName, Class<T> valueType) throws IOException {
        var relPath = Paths.get("src", "test", "resources", fileName);
        var absPath = relPath.toFile().getAbsolutePath();

        Object obj = mapper.readValue(new File(absPath), valueType);
        return (T) obj;
    }
}
