ublic class StringBuilderPattern {
    private StringBuilder stringBuilder;

    public StringBuilderPattern() {
        this.stringBuilder = new StringBuilder();
    }

    public StringBuilderPattern(String initialValue) {
        this.stringBuilder = new StringBuilder(initialValue);
    }


    public StringBuilderPattern append(String str) {
        stringBuilder.append(str);
        return this;
    }

    public StringBuilderPattern append(char ch) {
        stringBuilder.append(ch);
        return this;
    }

    public StringBuilderPattern append(int num) {
        stringBuilder.append(num);
        return this;
    }

    public StringBuilderPattern append(double num) {
        stringBuilder.append(num);
        return this;
    }

    public StringBuilderPattern append(Object obj) {
        stringBuilder.append(obj);
        return this;
    }


    public StringBuilderPattern insert(int position, String str) {
        if (position < 0 || position > stringBuilder.length()) {
            throw new IndexOutOfBoundsException(
                "Позиція " + position + " виходить за межі рядка (0-" + stringBuilder.length() + ")"
            );
        }
        stringBuilder.insert(position, str);
        return this;
    }

    public StringBuilderPattern insert(int position, char ch) {
        if (position < 0 || position > stringBuilder.length()) {
            throw new IndexOutOfBoundsException(
                "Позиція " + position + " виходить за межі рядка (0-" + stringBuilder.length() + ")"
            );
        }
        stringBuilder.insert(position, ch);
        return this;
    }

    public StringBuilderPattern insert(int position, int num) {
        if (position < 0 || position > stringBuilder.length()) {
            throw new IndexOutOfBoundsException(
                "Позиція " + position + " виходить за межі рядка (0-" + stringBuilder.length() + ")"
            );
        }
        stringBuilder.insert(position, num);
        return this;
    }

    public StringBuilderPattern appendLine() {
        stringBuilder.append(System.lineSeparator());
        return this;
    }

    public StringBuilderPattern appendLine(String str) {
        stringBuilder.append(str).append(System.lineSeparator());
        return this;
    }

    public StringBuilderPattern delete(int start, int end) {
        stringBuilder.delete(start, end);
        return this;
    }

    public StringBuilderPattern replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        return this;
    }

    public int length() {
        return stringBuilder.length();
    }

    public StringBuilderPattern clear() {
        stringBuilder.setLength(0);
        return this;
    }

    public StringBuilderPattern reverse() {
        stringBuilder.reverse();
        return this;
    }

    public CustomString build() {
        return new CustomString(stringBuilder.toString());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}

