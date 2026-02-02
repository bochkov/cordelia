package cordelia.client;

import java.util.concurrent.atomic.AtomicReference;

final class SessionStore {

    private final AtomicReference<Session> ref = new AtomicReference<>(null);

    boolean isEmpty() {
        return ref.get() == null
                || ref.get().getId() == null
                || ref.get().getId().isEmpty();
    }

    void set(Session session) {
        ref.set(session);
    }

    Session get() {
        return ref.get();
    }
}
