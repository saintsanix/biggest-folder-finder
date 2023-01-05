import java.io.File;

public class ParametersBag {
    private long limit;
    private String path;

    public ParametersBag(String args[]) {
        if (args.length != 4) {
            throw new IllegalArgumentException("������� ��� ���������: -l (����� �� ������) � -d (���� � �����)");
        }

        limit = 0;
        path = "";
        for (int i = 0; i < 4; i = i + 2) {
            if (args[i].equals("-l")) {
                limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);
            } else if (args[i].equals("-d")) {
                path = args[i + 1];
            }
        }

        if (limit <= 0) {
            throw new IllegalArgumentException("����� �� ������ ��� ������ �������");
        }
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("���� � ����� �� ������ ��� ������ �������");
        }
    }

    public long getLimit() {
        return limit;
    }

    public String getPath() {
        return path;
    }
}