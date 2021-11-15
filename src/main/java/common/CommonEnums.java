package common;

public final class CommonEnums {

    public enum Unit {
        HORIZONTAL ("HORIZONTAL"),
        VERTICAL   ("VERTICAL"),
        DIAGONAL   ("DIAGONAL");

        private final String e_name;

        Unit(String name)
            { this.e_name = name; }

        public String getName() { return e_name; }
   }

    public enum Browsers {
        CHROME ("chrome"),
        FIREFOX   ("firefox"),
        EDGE ("edge");

        private final String e_name;

        Browsers(String name)
            { this.e_name = name; }

        public String getName() { return e_name; }
   }
    
}
