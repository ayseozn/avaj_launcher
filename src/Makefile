defult: start

build:
	@find * -name "*.java" > sources.txt
	@javac @sources.txt

run:
#@java -cp . $(shell cat sources.txt | head -n 1 | sed 's/\.java//' | sed 's/\//./g')
	@java -cp . avaj_launcher.Main avaj_launcher/scenario.txt
	@echo "Running the program..."

start: build run

clean:
	@find . -name "*.class" -exec rm -f {} \;
	@rm -f sources.txt
	@rm -f simulation.txt

fclean: clean build run

.PHONY: build clean fclean run start

# make: derler ve çalıştırır
# make build: derler
# make run: çalıştırır
# make start: derler ve çalıştırır
# make clean: derlenmiş dosyaları siler
# make fclean: derlenmiş dosyaları siler, tekrar derler ve çalıştırır