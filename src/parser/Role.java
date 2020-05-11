package parser;

import java.util.LinkedList;

import org.json.JSONArray;

import io.github.vletard.analogy.sequence.Sequence;

public class Role extends IEMLSequence<IEMLStringAttribute> {
  
  private static final long serialVersionUID = 72985125223312666L;

  private static LinkedList<IEMLStringAttribute> extractJSON(JSONArray arr){ // TODO switch to factory
    LinkedList<IEMLStringAttribute> l = new LinkedList<IEMLStringAttribute>();
    for (int i = 0; i < arr.length(); i++)
      l.add(new IEMLStringAttribute(arr.getString(i)));
    return l;
  }

  public Role(JSONArray arr) {
    super(extractJSON(arr));
  }

  private Role(Sequence<IEMLStringAttribute> s) {
    super(s);
  }

  @SuppressWarnings("unchecked")
  public static Role reFactory(Sequence<?> s) throws IncompatibleSolutionException {
    try {
      return new Role((Sequence<IEMLStringAttribute>) s);
    } catch (ClassCastException e) {
      throw new IncompatibleSolutionException(e);
    }
  }
}
