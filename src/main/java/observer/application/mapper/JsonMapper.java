package observer.application.mapper;

public interface JsonMapper {

    <R> R toObject(String json, Class<R> object);
    String toJson(Object value);

}
