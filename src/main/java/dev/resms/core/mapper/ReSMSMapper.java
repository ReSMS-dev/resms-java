package dev.resms.core.mapper;

import com.squareup.moshi.Moshi;
import java.io.IOException;

/**
 * Implementation of the IMapper interface for mapping between JSON representation and Java objects
 * using Moshi.
 */
public class ReSMSMapper implements IMapper {

  private final Moshi moshi;

  public ReSMSMapper() {
    this.moshi = new Moshi.Builder().build();
  }

  /**
   * Converts the provided object into its JSON representation.
   *
   * @param object The object to be converted to JSON.
   * @return The JSON representation of the object.
   */
  @Override
  public String writeValue(Object object) {
    return moshi.adapter(Object.class).toJson(object);
  }

  /**
   * Converts the provided JSON value into an instance of the specified class.
   *
   * @param value The JSON value to be converted.
   * @param clazz The class to convert the JSON value to.
   * @param <T> The type of the resulting object.
   * @return An instance of the specified class with values from the JSON value.
   */
  @Override
  public <T> T readValue(String value, Class<T> clazz) {
    try {
      return moshi.adapter(clazz).fromJson(value);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
