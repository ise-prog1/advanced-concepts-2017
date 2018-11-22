import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
			String line = null;
			ArrayList<String> lines = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
			String line = null;
			ArrayList<String> lines = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("file.txt"), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
