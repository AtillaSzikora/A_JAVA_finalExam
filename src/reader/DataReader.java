package reader;

import entity.Person;
import entity.SearchType;

import java.util.Set;

public abstract class DataReader {

    String searchCriteria;
    SearchType searchType;

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public abstract Set<Person> getPersons();
}
