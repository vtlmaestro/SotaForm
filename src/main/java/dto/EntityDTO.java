package dto;


public class EntityDTO<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityDTO)) return false;

        EntityDTO<?> entity = (EntityDTO<?>) o;

        return getId().equals(entity.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}