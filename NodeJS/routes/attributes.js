var express=require('express');
var body =require('body-parser');
var router =express.Router();
var mongoose=require('mongoose');
var Attribute=require('../models/Attribute');


  // ajout attribut
  router.post('/add',  (req,res) => {
   
   
    const attribute = new Attribute({
        default_value: req.body.default_value,
        code: req.body.code,
        hierarchy_code: req.body.hierarchy_code,
        roles: req.body.roles,
        validations: req.body.validations,
        required: req.body.required,
        variant: req.body.variant,
        description_translations: req.body.description_translations,
        label: req.body.label,
        label_translations:{
            locale: req.body.locale,
            value: req.body.value,
        },
        values: req.body.values,
        requirement_level: req.body.requirement_level,
        values_list: req.body.values_list,
        type: req.body.type,
        example: req.body.example,

        type_parameter: req.body.type_parameter,
        description: req.body.description
       
    });
    attribute.save()
    .then(attribute => {
        res.json(attribute);
    })
       .catch(err => console.log(err));
    });

// modif attribut
    router.put('/update/:id',  (req,res) => {
        Attribute.findByIdAndUpdate(req.params.id,{
            default_value: req.body.default_value,
        code: req.body.code,
        hierarchy_code: req.body.hierarchy_code,
        roles: req.body.roles,
        validations: req.body.validations,
        required: req.body.required,
        variant: req.body.variant,
        description_translations: req.body.description_translations,
        label: req.body.label,
        label_translations:{
            locale: req.body.locale,
            value: req.body.value,
        },
        values: req.body.values,
        requirement_level: req.body.requirement_level,
        values_list: req.body.values_list,
        type: req.body.type,
        example: req.body.example,

        type_parameter: req.body.type_parameter,
        description: req.body.description
        }, {new: true})
            .then(attribute => {
                if(!attribute) {
                    return res.status(404).send({
                        msg: "attribute not found with id " + req.params.id
                    });
                } else {
                    res.json(attribute);
                }
            });
     });

// supprimer attribut
     router.delete('/delete/:id', (req,res) => {
        Attribute.findByIdAndRemove(req.params.id)
                .then(attribute => {
                    if(!attribute) {
                        return res.status(404).send({
                            msg: "attribute not found with id " + req.params.id
                        });
                    } else {
                        res.json({msg: "attribute deleted successfully!"});
                    }
                });
     });

module.exports = router;