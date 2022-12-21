package furniture_production.styles;

public class FrenchStyle implements Style {
    public String getDescriptionForSofa() {
        return "French style" + "    Colors:" + " green, ecru" + "    Cover:" + " floral" + "    Wooden elements:" + " dark oak";

    }

    public String getDescriptionForTable() {
        return "French style" + "    Colors:" + " dark brown" + "    Material:" + " oak";

    }

    public String getName() {
        return "French";
    }
}
