import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class FileUtils {
    /**
     * mỗi đối tượng muốn ghi được phải có thì phải viết lại hàm toString() có dạng {name:"abc", age:12}
     * @param fileName : chỉ định tên file muốn ghi
     * @param obj : truyền vào đối tượng chứa dữ liệu vd: Student, List<Student>
     * @return
     * */
    public static void writeTextFile(String fileName, Object obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (obj instanceof Iterable<?>) {
                for (Object item : (Iterable<?>) obj) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            } else {
                writer.write(obj.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @param clazz vd: muốn đọc danh sanh học sinh thì truyền vào Student.class
     * @return trả về danh sách các đối tượng được ghi trong file
     * */
    public static <T> List<T> readTextFileAsList(String fileName, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T obj = parseLineToObject(line, clazz);
                resultList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private static <T> T parseLineToObject(String line, Class<T> clazz) throws Exception {
        Map<String, String> fieldMap = parseToMap(line);
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            Object value = convertValue(field.getType(), entry.getValue());
            field.set(instance, value);
        }

        return instance;
    }

    private static Map<String, String> parseToMap(String input) {
        Map<String, String> map = new HashMap<>();
        input = input.trim();
        if (input.startsWith("{") && input.endsWith("}")) {
            input = input.substring(1, input.length() - 1);
            String[] pairs = input.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                if (keyValue.length == 2) {
                    map.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        }
        return map;
    }

    private static Object convertValue(Class<?> type, String value) {
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == double.class || type == Double.class) return Double.parseDouble(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        if (type == long.class || type == Long.class) return Long.parseLong(value);
        return value; // default: String
    }

    /**
     * đối tượng phải implement Serializable
     * @param fileName
     * @param objList vd: danh sách các đối tượng
     * */
    public static void writeBinaryFile(String fileName, List<?> objList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(objList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @param clazz vd: ví dụ truyền vào
     * @return danh sách các đối tượng có kiểu dữ liệu là T
     * */
    public static <T> List<T> readBinaryFileAsList(String fileName, Class<T> clazz) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
