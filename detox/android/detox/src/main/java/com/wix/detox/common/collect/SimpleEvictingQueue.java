package com.wix.detox.common.collect;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class SimpleEvictingQueue<E> extends AbstractQueue<E> {

  private final LinkedList<E> content;
  private final int maxSize;

  public SimpleEvictingQueue(int maxSize) {
    content = new LinkedList<>();
    this.maxSize = maxSize;
  }

  /**
   * Adds the given element to this queue. If the queue is currently full, the element at the head
   * of the queue is evicted to make room.
   *
   * @return {@code true} always
   */
  @Override
  public boolean offer(E e) {
    if (content.size() == maxSize) {
      content.removeLast();
    }
    content.addFirst(e);
    return true;
  }

  @Nullable
  @Override
  public E poll() {
    return content.poll();
  }

  @Nullable
  @Override
  public E peek() {
    return content.peek();
  }


  @NonNull
  @Override
  public Iterator<E> iterator() {
    return content.iterator();
  }

  @Override
  public int size() {
    return content.size();
  }

  public E getAt(int index) {
    return content.get(index);
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {
    for (E item : collection) {
      add(item);
    }
    return true;
  }
}
