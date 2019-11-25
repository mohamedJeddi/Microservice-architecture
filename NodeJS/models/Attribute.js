var mongoose=require('mongoose');
var attributeSchema=mongoose.Schema({

    default_value:{
        type :String,
    },
    code:{
        type :String,
       required: true
    },
    hierarchy_code:{
        type:String,
        required:true
    },
    roles:[{
        type:String,
    }],
    validations:{
        type:String,
        required:true
    },
    required:{
        type:Boolean,
    }
    ,
    variant:{
        type:Boolean,
    },
    description_translations:[{
        type:String,
    }],
    label:{
        type:String,
    },
    label_translations:[
        {
            locale:{
                type:String,
            },
            value:{
                type:String,
            },
        }
    ],
    values:{
        type:String,
     },
    requirement_level:{
        type:String,
     }, 
    values_list:{
        type:String,
     }, 
    type:{
        type:String,
     },  
    example:{
        type:String,
     },  
    type_parameter:{
        type:String,
     },  
    description:{
        type:String,
     },
});
var attribute = mongoose.model('Attribute',attributeSchema);

module.exports = attribute;
