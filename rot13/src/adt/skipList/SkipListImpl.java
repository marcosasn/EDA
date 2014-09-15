package adt.skipList;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;
	
	protected boolean useMaxLevelAsLevel = true;
	protected double probability = 0.5;
	protected SkipNode<V> NIL;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListImpl(int maxLevel) {
		if (useMaxLevelAsLevel) {
			this.level = maxLevel;
		} else {
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(
				Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(
				Integer.MAX_VALUE));
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxLevel; i++) {
			root.getForward()[i] = NIL;
		}
	}

	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no
	 * metodo insert(int,V)
	 */
	private int randomLevel() {
		int randomLevel = 1;
		double random = Math.random();
		while (Math.random() <= probability && randomLevel < maxLevel) {
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}

	@Override
	public void insert(int key, V newValue) {
		insert(key, newValue, randomLevel());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, V newValue, int height) {
		SkipNode<V>[] update = new SkipNode[level];
		SkipNode<V> x = root;
		
		for (int i = level-1; i >= 0; i--) {
			while (x.getForward(i).getKey() < key) {
				x = x.getForward(i);
			}
			update[i] = x;
		}
		x = x.getForward(0);
		
		if (x.getKey() == key) {
			x.satteliteData = newValue;
		}
		else {
			if (height <= maxLevel) {
				if (height > level) {
					for (int i = level ;i < height; i++) {
						update[i] = root;
					}
					level = height; 
				}
				x = new SkipNode<V>(key, height, newValue);
					
				for (int i = 0; i < height; i++) {
					x.forward[i] = update[i].getForward(i); 
					update[i].forward[i] = x; 
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	//VER ESSE
	public void remove(int key) {
		if (this.search(key) != null) {
			SkipNode<V>[] update = new SkipNode[level];
			SkipNode<V> x = root;
			
			for (int i = level-1; i >= 0; i--) {
				while (x.getForward(i).getKey() < key) {
					x = x.getForward(i);
				}
				update[i] = x;
			}
			
			x = x.getForward(0);
			if (x.getKey() == key) {
				for (int i = 0; i < level; i++) {
					if (!update[i].forward[i].equals(x)) {
						break;
					}
					update[i].forward[i] = x.getForward(i);
					
					while (level > 0 && root.forward[level].equals(NIL)) {
						level--;
					}
				}
			}
		}		
	}

	@Override
	public int height() {
		return level;
	}

	@Override
	public SkipNode<V> search(int key) {
		SkipNode<V> result = root;
		for (int i = level-1; i >= 0; i--) {
			while (result.getForward(i).getKey() < key) {
				result = result.getForward(i);
			}
		}
		result = result.getForward(0);
		if (result.getKey() == key) {
			return result;
		}
		return null;
	}

	@Override
	public int size() {
		int size = 0;
		SkipNode<V> node = root;
		while (!node.getForward(0).equals(NIL)) {
			node = node.getForward(0);
			size++;
		}
		return size;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public SkipNode<V>[] toArray() {
		SkipNode<V> [] array = new SkipNode[this.size()];
		SkipNode<V> node = root;
		int i = 0;
		while(!node.getForward(0).equals(NIL)) {
			array[i++] = node;
			node = node.getForward(0);
		}
		return array;
	}
	
	public SkipNode<V>[] toArray2() {
		SkipNode<V> [] array = new SkipNode[this.size()];
		SkipNode<V> node = root.getForward(0);
		int i = 0;
		while(!node.equals(NIL)) {
			array[i++] = node;
			node = node.getForward(0);
		}
		return array;
	}
	
	public SkipNode<V>[] toArray3() {
		SkipNode<V> [] array = new SkipNode[this.size()];
		int i = 0;
		for (int j = level-1; j >= 0; j--) {
			SkipNode<V> node = root;
			while (node.getForward(j).height == j) {
				array[i++] = node;
				node = node.getForward(j);
			}
			node = node.getForward(j);
		}
		return array;
	}
}