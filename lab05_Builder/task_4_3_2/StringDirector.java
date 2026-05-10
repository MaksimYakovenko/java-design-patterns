// Director для створення типових рядків
public class StringDirector {

    public CustomString buildHTMLDocument(String title, String body) {
        return new StringBuilderPattern()
                .appendLine("<!DOCTYPE html>")
                .appendLine("<html>")
                .appendLine("<head>")
                .append("    <title>").append(title).appendLine("</title>")
                .appendLine("</head>")
                .appendLine("<body>")
                .append("    ").appendLine(body)
                .appendLine("</body>")
                .appendLine("</html>")
                .build();
    }

    public CustomString buildJSON(String[][] fields) {
        StringBuilderPattern builder = new StringBuilderPattern()
                .appendLine("{");

        for (int i = 0; i < fields.length; i++) {
            builder.append("  \"").append(fields[i][0]).append("\": \"").append(fields[i][1]).append("\"");
            if (i < fields.length - 1) {
                builder.append(",");
            }
            builder.appendLine();
        }

        return builder.appendLine("}").build();
    }

    public CustomString buildSQLInsert(String tableName, String[] columns, String[] values) {
        StringBuilderPattern builder = new StringBuilderPattern()
                .append("INSERT INTO ")
                .append(tableName)
                .append(" (");

        for (int i = 0; i < columns.length; i++) {
            builder.append(columns[i]);
            if (i < columns.length - 1) {
                builder.append(", ");
            }
        }

        builder.append(") VALUES (");

        for (int i = 0; i < values.length; i++) {
            builder.append("'").append(values[i]).append("'");
            if (i < values.length - 1) {
                builder.append(", ");
            }
        }

        return builder.append(");").build();
    }

    public CustomString buildList(String[] items, boolean numbered) {
        StringBuilderPattern builder = new StringBuilderPattern();

        for (int i = 0; i < items.length; i++) {
            if (numbered) {
                builder.append(i + 1).append(". ");
            } else {
                builder.append("• ");
            }
            builder.appendLine(items[i]);
        }

        return builder.build();
    }

    public CustomString buildTable(String[] headers, String[][] rows) {
        StringBuilderPattern builder = new StringBuilderPattern();

        // Заголовки
        builder.append("| ");
        for (String header : headers) {
            builder.append(header).append(" | ");
        }
        builder.appendLine();

        // Роздільник
        builder.append("|");
        for (int i = 0; i < headers.length; i++) {
            builder.append("------|");
        }
        builder.appendLine();

        // Дані
        for (String[] row : rows) {
            builder.append("| ");
            for (String cell : row) {
                builder.append(cell).append(" | ");
            }
            builder.appendLine();
        }

        return builder.build();
    }

    public CustomString buildEmail(String from, String to, String subject, String body) {
        return new StringBuilderPattern()
                .append("From: ").appendLine(from)
                .append("To: ").appendLine(to)
                .append("Subject: ").appendLine(subject)
                .appendLine()
                .appendLine(body)
                .build();
    }

    public CustomString buildURL(String baseUrl, String[][] params) {
        StringBuilderPattern builder = new StringBuilderPattern()
                .append(baseUrl);

        if (params != null && params.length > 0) {
            builder.append("?");
            for (int i = 0; i < params.length; i++) {
                builder.append(params[i][0]).append("=").append(params[i][1]);
                if (i < params.length - 1) {
                    builder.append("&");
                }
            }
        }

        return builder.build();
    }
}

