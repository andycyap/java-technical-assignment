package kata.supermarket;

import java.util.List;

public interface IRule {

    /**
     * Search the list if Item and appy the rule if applicable
     * @param list
     */
	void apply(List<Item> list);

}