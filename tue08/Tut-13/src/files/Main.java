package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	static class Kunde {
		public int kundenNummer;
		public String nachname;
		public String vorname;
		public String strasse;
		public int plz;
		public String ort;
		@Override
		public String toString() {
			return "Kunde [kundenNummer=" + kundenNummer + ", nachname=" + nachname + ", vorname=" + vorname
					+ ", strasse=" + strasse + ", plz=" + plz + ", ort=" + ort + "]";
		}
		
		public String toCsvString(String csvSeperator) {
			return kundenNummer + csvSeperator + 
			nachname + csvSeperator + 
			vorname + csvSeperator + 
			strasse + csvSeperator + 
			plz + csvSeperator + 
			ort;
		}
	}

	public static void main(String[] args) throws IOException {
		Path input = Paths.get(".", "input.txt");
		// Old api is java.io.File
		//File file = input.toFile();
		//file.toPath();
		List<String> elements = null;
		try (BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8)) {
			elements = reader.lines().skip(6).collect(Collectors.toList());
		}
		List<Kunde> kunden = parseKunden(elements);
		
		System.out.println(kunden);

		Path output = Paths.get(".", "output.csv");
		
		try (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
			writer.write("Kundennummer,Nachname,Vorname,Strasse,Postleitzahl,Ort");
			writer.newLine();
			for (Kunde k : kunden) {
				writer.write(k.toCsvString(","));
				writer.newLine();
			}
		}
		
	}
	
	public static List<Kunde> parseKunden(List<String> lines) {
		List<Kunde> kunden = new ArrayList<>();
		Kunde k = null;
		int tracker = 0;
		for (String s : lines) {
			if (s.trim().equals("")) {
				k = new Kunde();
				tracker = 0;
				continue;
			}
			if (tracker == 0) {
				k.kundenNummer = Integer.parseInt(s);
				tracker++;
				continue;
			}
			if (tracker == 1) {
				k.nachname = s;
				tracker++;
				continue;
			}
			if (tracker == 2) {
				k.vorname = s;
				tracker++;
				continue;
			}
			if (tracker == 3) {
				k.strasse = s;
				tracker++;
				continue;
			}
			if (tracker == 4) {
				k.plz = Integer.parseInt(s);
				tracker++;
				continue;
			}
			if (tracker == 5) {
				k.ort = s;
				kunden.add(k);
				tracker++;
				continue;
			}
		}
		return kunden;
	}
}
