package dev.alexissdev.events.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;
import team.unnamed.pixel.storage.ModelService;
import team.unnamed.pixel.storage.model.Model;

public class ConcurrentLocalModelService<T extends Model>
    implements ModelService<T> {

  private final Map<String, T> cache = new ConcurrentHashMap<>();

  public static <T extends Model> ModelService<T> create() {
    return new ConcurrentLocalModelService<>();
  }

  @Override
  public @Nullable T findSync(String id) {
    return cache.get(id);
  }

  @Override
  public List<T> findSync(String field, String value) {
    return Collections.singletonList(cache.get(value));
  }

  @Override
  public List<T> findAllSync() {
    return new ArrayList<>(cache.values());
  }

  @Override
  public List<T> findAllSync(Consumer<T> postLoadAction) {
    return findAllSync();
  }

  @Override
  public void saveSync(T model) {
    cache.put(model.getId(), model);
  }

  @Override
  public void deleteSync(T model) {
    cache.remove(model.getId());
  }

  @Override
  public T deleteSync(String id) {
    return cache.remove(id);
  }

}
