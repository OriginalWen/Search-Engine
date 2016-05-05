# Search-Engine

The problem is that some medical terms have multiple names.  As a result, our search functionality needs to returns not only the medical topics that contain the search keyword but also any medical topics that contain similar medical terms that are synonymous with the keyword.
There is a synonyms.properties file included with this document that contains a collection of synonyms.  Each entry in this resource bundle represents a group of words that are synonyms of each other separated by a comma.  
There is also a quotes.properties file included with this document that contains a bunch of quotes.  Each entry in this resource bundle represents a quote.  


Example Output

For example, if we had the following lines in quotes.properties:

quote.6=You miss 100% of the shots you don’t take. –Wayne Gretzky
	quote.89=If you do what you’ve always done, you’ll get what you’ve always gotten. –Tony Robbins

And this line in synonyms.properties:

	synonym.group.1=accept,acquire,gain,get,obtain,secure,take

And the search term was “acquire”, the output would be:
 	quote.6 take
quote.89 get
