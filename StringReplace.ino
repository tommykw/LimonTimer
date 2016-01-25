void setup() {
  Serial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect
  }

  Serial.println();
}

void loop() {
  String one = "<html><head><body>";
  Serial.println(one);

  String two = one;
  two.replace("<", "</");
  Serial.println(one);
  Serial.println(two);

  String normalString = "book";
  Serial.println(normalString);
  String leetString = normalString;
  leetString.replace('o', '0');
  leetString.replace('e', '3');
  Serial.println(leetString);

  // do nothing while true
  while (true);
}
