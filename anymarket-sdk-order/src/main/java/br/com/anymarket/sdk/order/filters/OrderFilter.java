package br.com.anymarket.sdk.order.filters;

import br.com.anymarket.sdk.http.filters.ApiFilter;

import java.util.Objects;

/**
 *
 */
public abstract class OrderFilter implements ApiFilter {

    private String value;

    public OrderFilter(String value) {
        this.value = value;
    }

    @Override
    public abstract String getKey();

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderFilter that = (OrderFilter) o;
        return Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
