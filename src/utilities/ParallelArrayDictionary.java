/**
* A class that implements an arraySet using an underlying arrayList
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author <Moultrie Dangerfield>
* @date <08/30/23>
*/


package utilities;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
    protected ArraySet<Key>    _keys;
    protected ArrayList<Value> _values;
	
	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return size()== 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		int index = _keys.indexOf(key);
		return _values.get(index); 
	}

	@Override
	public Value put(Key key, Value value) {
		_keys.add(key);
		_values.add(value);
		return value;
	}

	@Override
	public Value remove(Object key) {
		Value v = _values.get(_keys.indexOf(key));
		_keys.remove(_keys.indexOf(key));
		return v;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		
		for(Entry<? extends Key, ? extends Value> pair: m.entrySet()) {
			put(pair.getKey(), pair.getValue());
		}
		
	}

	@Override
	public void clear() {
		_keys.clear();
	}

	@Override
	public Set<Key> keySet() {
		return _keys;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return _values;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}