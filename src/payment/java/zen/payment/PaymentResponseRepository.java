package zen.payment;

import java.util.List;
import java.util.Optional;

/**
 * Repository for managing payment responses.
 * Provides CRUD operations for PaymentResponse entities.
 */
public class PaymentResponseRepository {

  private final PaymentResponseStore store;

  /**
   * Constructs a PaymentResponseRepository with the given store.
   *
   * @param store the underlying storage implementation
   */
  public PaymentResponseRepository(PaymentResponseStore store) {
    this.store = store;
  }

  /**
   * Saves a payment response to the store.
   *
   * @param response the payment response to save
   * @throws IllegalArgumentException if the response is null
   * @throws RepositoryException if saving fails
   */
  public void save(PaymentResponse response) {
    if (response == null) {
      throw new IllegalArgumentException(
        "Payment response cannot be null");
    }
    try {
      store.save(response);
    } catch (StoreException e) {
      throw new RepositoryException("Failed to save payment response", e);
    }
  }

  /**
   * Finds a payment response by its identifier.
   *
   * @param id the identifier of the payment response
   * @return an Optional containing the found response, or empty if not found
   * @throws RepositoryException if the lookup fails
   */
  public Optional<PaymentResponse> findById(String id) {
    if (id == null || id.isEmpty()) {
      return Optional.empty();
    }
    try {
      return store.findById(id);
    } catch (StoreException e) {
      throw new RepositoryException(
        "Failed to find payment response with id: " + id, e);
    }
  }

  /**
   * Retrieves all payment responses from the store.
   *
   * @return a list of all payment responses
   * @throws RepositoryException if retrieval fails
   */
  public List<PaymentResponse> findAll() {
    try {
      return store.findAll();
    } catch (StoreException e) {
      throw new RepositoryException(
        "Failed to retrieve all payment responses", e);
    }
  }

  /**
   * Deletes a payment response by its identifier.
   *
   * @param id the identifier of the payment response to delete
   * @throws IllegalArgumentException if id is null or empty
   * @throws RepositoryException if deletion fails
   */
  public void deleteById(String id) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException(
        "Payment response id cannot be null or empty");
    }
    try {
      store.deleteById(id);
    } catch (StoreException e) {
      throw new RepositoryException(
        "Failed to delete payment response with id: " + id, e);
    }
  }

  /**
   * Checks if a payment response with the given id exists.
   *
   * @param id the identifier to check
   * @return true if a response with the given id exists, false otherwise
   */
  public boolean existsById(String id) {
    if (id == null || id.isEmpty()) {
      return false;
    }
    try {
      return store.existsById(id);
    } catch (StoreException e) {
      throw new RepositoryException(
        "Failed to check existence of payment response with id: " + id, e);
    }
  }

  /**
   * Updates an existing payment response in the store.
   *
   * @param response the payment response with updated values
   * @throws IllegalArgumentException if the response is null
   * @throws RepositoryException if update fails
   */
  public void update(PaymentResponse response) {
    if (response == null) {
      throw new IllegalArgumentException(
        "Payment response cannot be null");
    }
    try {
      store.update(response);
    } catch (StoreException e) {
      throw new RepositoryException(
        "Failed to update payment response", e);
    }
  }
}
