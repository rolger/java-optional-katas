package optional;

import optional.model.Country;

public interface RestCountriesAPI {

    public boolean isInCommonMarket(Country country);

    public boolean isInAmericas(Country country);

    public int distanceTo(Country country);
}
