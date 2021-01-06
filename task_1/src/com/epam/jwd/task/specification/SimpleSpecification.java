package com.epam.jwd.task.specification;

public class SimpleSpecification extends Specification {

    public static class Builder extends Specification.Builder<Builder> {

        @Override
        public SimpleSpecification build() {
            return new SimpleSpecification(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public SimpleSpecification(Builder builder) {
        super(builder);
    }
}
