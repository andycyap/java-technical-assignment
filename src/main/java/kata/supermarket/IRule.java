package kata.supermarket;


public interface IRule {

    /**
     * Search the list if Item and appy the rule if applicable
     * @param list
     */
	void apply(Basket basket);

}