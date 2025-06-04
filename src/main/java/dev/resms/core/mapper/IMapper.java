package dev.resms.core.mapper;

/** An interface for mapping between JSON representation and Java objects using Moshi. */
public interface IMapper {

  /**
   * Converts the provided object into its JSON representation.
   *
   * @param object The object to be converted to JSON.
   * @return The JSON representation of the object.
   */
  String toJson(Object object);

  /**
   * Converts the provided JSON value into an instance of the specified class.
   *
   * @param value The JSON value to be converted.
   * @param clazz The class to convert the JSON value to.
   * @param <T> The type of the resulting object.
   * @return An instance of the specified class with values from the JSON value.
   */
  <T> T fromJson(String value, Class<T> clazz);
}
