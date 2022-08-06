package observer.application.rest;

public interface JsonMapper {

    <R> R toObject(String json, Class<R> object);
    String toJson(Object value);

}
