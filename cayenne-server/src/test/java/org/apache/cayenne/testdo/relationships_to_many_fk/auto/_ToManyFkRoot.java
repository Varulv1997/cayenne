package org.apache.cayenne.testdo.relationships_to_many_fk.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.NumericProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;
import org.apache.cayenne.testdo.relationships_to_many_fk.ToManyFkDep;

/**
 * Class _ToManyFkRoot was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ToManyFkRoot extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final NumericProperty<Integer> ID_PK_PROPERTY = PropertyFactory.createNumeric(ExpressionFactory.dbPathExp("ID"), Integer.class);
    public static final String ID_PK_COLUMN = "ID";

    public static final NumericProperty<Integer> DEP_ID = PropertyFactory.createNumeric("depId", Integer.class);
    public static final StringProperty<String> NAME = PropertyFactory.createString("name", String.class);
    public static final ListProperty<ToManyFkDep> DEPS = PropertyFactory.createList("deps", ToManyFkDep.class);

    protected Integer depId;
    protected String name;

    protected Object deps;

    public void setDepId(Integer depId) {
        beforePropertyWrite("depId", this.depId, depId);
        this.depId = depId;
    }

    public Integer getDepId() {
        beforePropertyRead("depId");
        return this.depId;
    }

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void addToDeps(ToManyFkDep obj) {
        addToManyTarget("deps", obj, true);
    }

    public void removeFromDeps(ToManyFkDep obj) {
        removeToManyTarget("deps", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<ToManyFkDep> getDeps() {
        return (List<ToManyFkDep>)readProperty("deps");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "depId":
                return this.depId;
            case "name":
                return this.name;
            case "deps":
                return this.deps;
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
            case "depId":
                this.depId = (Integer)val;
                break;
            case "name":
                this.name = (String)val;
                break;
            case "deps":
                this.deps = val;
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
        out.writeObject(this.depId);
        out.writeObject(this.name);
        out.writeObject(this.deps);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.depId = (Integer)in.readObject();
        this.name = (String)in.readObject();
        this.deps = in.readObject();
    }

}
