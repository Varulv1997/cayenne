package org.apache.cayenne.testdo.relationships_collection_to_many.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.testdo.relationships_collection_to_many.CollectionToMany;

/**
 * Class _CollectionToManyTarget was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CollectionToManyTarget extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final EntityProperty<CollectionToMany> COLLECTION_TO_MANY = PropertyFactory.createEntity("collectionToMany", CollectionToMany.class);


    protected Object collectionToMany;

    public void setCollectionToMany(CollectionToMany collectionToMany) {
        setToOneTarget("collectionToMany", collectionToMany, true);
    }

    public CollectionToMany getCollectionToMany() {
        return (CollectionToMany)readProperty("collectionToMany");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "collectionToMany":
                return this.collectionToMany;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "collectionToMany":
                this.collectionToMany = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.collectionToMany);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.collectionToMany = in.readObject();
    }

}
